package com.maybetm.configuration;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.IOException;

/**
 * @author zebzeev-sv
 * @version 29.09.2019 23:37
 */
public class EmbeddedPostgresInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

  @Override
  public void initialize(GenericApplicationContext applicationContext) {
    final EmbeddedPostgres postgres = new EmbeddedPostgres();
    try {
      final String url = postgres.start();
      TestPropertyValues values = TestPropertyValues.of(
          "spring.test.database.replace=none",
          "spring.datasource.url=" + url,
          "spring.datasource.username=" + EmbeddedPostgres.DEFAULT_USER,
          "spring.datasource.password=" + EmbeddedPostgres.DEFAULT_PASSWORD,
          "spring.datasource.driver-class-name=org.postgresql.Driver",
          "spring.jpa.hibernate.ddl-auto=update",
          "spring.jpa.open-in-view=true",
          "spring.datasource.initialization-mode=always",
          "spring.datasource.data=" +
          "classpath*:sql/import_roles.sql," +
          "classpath*:sql/import_accounts.sql," +
          "classpath*:sql/import_category.sql"
      );
      values.applyTo(applicationContext);
      applicationContext.registerBean(EmbeddedPostgres.class,
                                      () -> postgres,
                                      (beanDefinition) -> beanDefinition.setDestroyMethodName("stop"));
    } catch (Throwable e) {
      postgres.stop();
      throw new RuntimeException(e);
    }
  }
}
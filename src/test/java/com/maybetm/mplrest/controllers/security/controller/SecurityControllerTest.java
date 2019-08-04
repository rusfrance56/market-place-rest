package com.maybetm.mplrest.controllers.security.controller;

import com.maybetm.mplrest.ATest;
import com.maybetm.mplrest.entities.account.Account;
import com.maybetm.mplrest.entities.roles.Role;
import com.maybetm.mplrest.security.Roles;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Юнит тест для ендпойнта аутентификации
 * и идентификации пользователя {@link SecurityController}
 *
 * @author zebzeev-sv
 * @version 02.08.2019 15:32
 */
public class SecurityControllerTest extends ATest
{

  private static final String endpoint = "/auth/";
  private Account accountClient = new Account("", "email", "password", any(ZonedDateTime.class), new Role(Roles.client.id));

  @Test
  public void testLogin() throws Exception
  {
    mvcResult = mockMvc.perform(post(endpoint + "login")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                                    .content(objectMapper.writeValueAsString(accountClient)))
        .andReturn();
    logger.info("response: " + mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void testLogout() throws Exception
  {

  }

  @Test
  public void testDestroy() throws Exception
  {

  }
}
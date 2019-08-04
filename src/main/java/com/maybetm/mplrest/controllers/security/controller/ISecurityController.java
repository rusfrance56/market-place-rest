package com.maybetm.mplrest.controllers.security.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maybetm.mplrest.entities.account.Account;

/**
 * @author zebzeev-sv
 * @version 02.08.2019 15:23
 */
public interface ISecurityController
{
  // метод для аутентификации и идентификации
  // должен выполнить проверку подлинности пользователя в бд,
  // если пользователь прошёл проверку. То ему выдаётся jwt токен доступа, иначе вызываем пользовательское исключение.
  String login(Account account) throws JsonProcessingException;

  // стоит допустить механизм выхода из системы
  // Он подразумевает возможность отозвать пользовательский токен, который запросил ранее.
  // должен быть доступен только авторизированному пользователю (необходим ключ jwt).
  public void logout(String jwt);

  // так-же стоит предусмотреть
  // удаление токена администратором
  public void destroy();
}
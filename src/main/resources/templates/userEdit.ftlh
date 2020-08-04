<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<#import "parts/login.ftlh" as l>

<@c.page>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">blrBlog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/warehouse">Склад</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/production">Изготовление</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/sales">Продажа</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Отчеты
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/diapazone">Отчет по диапазонам</a>
                    <a class="dropdown-item" href="/report">Отчет за все время</a>
                </div>
            </li>
            <#if isAdmin>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown0" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Права админа
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown0">
                    <a class="dropdown-item" href="/user">Список пользователей</a>
                    <a class="dropdown-item" href="/adminproductions">Добавить новые рецептуры</a>
                    <a class="dropdown-item" href="/pricesettings">Добавить новые ценовые записи</a>
                </div>
            </li>
        </#if>
        </ul>


        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3"><@l.logout /></div>

    </div>
</nav>

<div>Задать роль польователю</div>

<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}" />
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Сохранить</button>
</form>

</@c.page>
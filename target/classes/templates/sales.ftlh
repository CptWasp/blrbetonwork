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
                    <a class="dropdown-item" href="#">Отчет по диапазонам</a>
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


     <a class="btn btn-primary my-3 mx-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новую продажу</a>
    <div class="collapse" id="collapseExample">
        <div class="form-group col-sm-10 col-md-6 mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="date" name="saledate" class="form-control" />
                </div>
                <div class="form-group">
                    <select class="form-control" name="salename">
                        <#list adminproductions as adminproduction>
                        <option class="dropdown-item" value="${adminproduction.adminproductname?string}">${adminproduction.adminproductname?string}</option>
                    </#list>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="saletotal" placeholder="Цена" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="salecount" placeholder="Количество" />
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="form-control btn btn-success">Добавить</button>
                </div>
            </form>
        </div>
    </div>

<br>
      
      
      <table class="table">
                      <thead>
                        <tr>
                          <th scope="col">Дата</th>
                          <th scope="col">Наименование</th>
                          <th scope="col">Цена</th>
                          <th scope="col">Количество</th>
                          <th scope="col">Имя создателя</th>
                        </tr>
                      </thead>
                      <tbody class="table-striped">
                      <#list sales as sale>
                        <tr>
                          <th scope="row">${sale.saledate}</th>
                          <td>${sale.salename}</td>
                          <td>${sale.saletotal}</td>
                          <td>${sale.salecount}</td>
                          <td>${sale.authorName}</td>
                        </tr>
                      </#list>
                      </tbody>
</table>


</@c.page>
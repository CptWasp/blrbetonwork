<#import "parts/common.ftlh" as c>

<@c.page>

<a class="btn btn-primary my-3 mx-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новую запись
</a>
    <div class="collapse" id="collapseExample">
        <div class="form-group col-sm-10 col-md-6 mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="date" name="productdate" class="form-control" />
                </div>
                <div class="form-group">

                    <select class="form-control" name="prodname">
                    <#list adminproductions as adminproduction>
                        <option class="dropdown-item" value="${adminproduction.adminproductname?string}">${adminproduction.adminproductname?string}</option>
                    </#list>
                    </select>

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="prodcount" placeholder="Количество" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="mencount" placeholder="Сколько человек" />
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
                          <th scope="col">Количество</th>
                          <th scope="col">Привлечение доп. раб. силы</th>
                          <th scope="col">Имя создателя</th>
                        </tr>
                      </thead>
                      <tbody class="table-striped">

                      <#list productions as production>
                            <tr>
                                <th scope="row">${production.productdate}</th>
                              <td>${production.prodname}</td>
                              <td>${production.prodcount}</td>
                              <td>${production.mencount}</td>
                              <td>${production.authorName}</td>
                            </tr>
                      </#list>
                      </tbody>
</table>



</@c.page>
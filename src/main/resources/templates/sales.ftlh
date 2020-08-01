<#import "parts/common.ftlh" as c>

<@c.page>
      
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
                        <option class="dropdown-item" value="Полимерный бетон">Полимерный бетон</option>
                        <option class="dropdown-item" value="Сверхлёгкий и Лёгкий бетон">Сверхлёгкий и Лёгкий бетон</option>
                        <option class="dropdown-item" value="Тяжёлый и сверхтяжёлый бетон">Тяжёлый и сверхтяжёлый бетон</option>
                    </select>

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="saletotal" placeholder="Количество" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="salecount" placeholder="Сколько человек" />
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
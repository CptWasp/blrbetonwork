<#import "parts/common.ftlh" as c>

<@c.page>

<a class="btn btn-primary my-3 mx-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить новый товар (Админ)</a>
<div class="collapse" id="collapseExample">
    <div class="form-group col-sm-10 col-md-6 mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" name="adminproductname" class="form-control" placeholder="Номенклатура 'ФБС 4'" />
            </div>
            <div class="form-group">
                <input type="text" name="adminproductbeton" class="form-control" placeholder="Бетон, м^3 '0.00'" />
            </div>
            <div class="form-group">
                <input type="text" name="adminproductwire" class="form-control" placeholder="Проволока, м '0.00'" />
            </div>
            <div class="form-group">
                <input type="text" name="adminproductarmature" class="form-control" placeholder="Армрматура, м '0.00'" />
            </div>
            <div class="form-group">
                <input type="text" name="adminproductgrid" class="form-control" placeholder="Сетка, м '0.00'" />
            </div>
            <div class="form-group">
                <input type="text" name="adminproducttotal" class="form-control" placeholder="Стоимость работы, руб. '0.00'" />
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
        <th scope="col">Номенклатура</th>
        <th scope="col">Бетон, м&#179</th>
        <th scope="col">Проволка, м</th>
        <th scope="col">Арматура, м</th>
        <th scope="col">Сетка, м</th>
        <th scope="col">Стоимость работы, руб.</th>
    </tr>
    </thead>
    <tbody class="table-striped">
    <#list adminproductions as adminproduction>
    <tr>
        <th scope="row">${adminproduction.adminproductname}</th>
        <td>${adminproduction.adminproductbeton}</td>
        <td>${adminproduction.adminproductwire}</td>
        <td>${adminproduction.adminproductarmature}</td>
        <td>${adminproduction.adminproductgrid}</td>
        <td>${adminproduction.adminproducttotal}</td>
    </tr>
    </#list>
    </tbody>
</table>


</@c.page>
<#import "parts/common.ftlh" as c>

<@c.page>

<a class="btn btn-primary my-3 mx-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить на склад</a>
<div class="collapse" id="collapseExample">
    <div class="form-group col-sm-10 col-md-6 mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <select class="form-control" name="warehousename">
                    <#list adminproductions as adminproduction>
                    <option class="dropdown-item" value="${adminproduction.adminproductname?string}">${adminproduction.adminproductname?string}</option>
                </#list>
                </select>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="warehousecount" placeholder="Количество" />
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
        <th scope="col">Количество</th>
    </tr>
    </thead>
    <tbody class="table-striped">
    <#list warehouses as warehouse>
    <tr>
        <th scope="row">${warehouse.warehousename}</th>
        <td>${warehouse.warehousecount}</td>
    </tr>
    </#list>
    </tbody>
</table>


</@c.page>
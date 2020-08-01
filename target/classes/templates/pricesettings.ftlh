<#import "parts/common.ftlh" as c>

<@c.page>

<a class="btn btn-primary my-3 mx-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить новую ценовую запись
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group col-sm-10 col-md-6 mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="date" name="pricedate" class="form-control" placeholder="Дата" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="wireprice" placeholder="Цена проволки" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="armatureprice" placeholder="Цена арматуры" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="gridprice" placeholder="Цена сетки" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="betonprice" placeholder="Цена бетона" />
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
        <th scope="col">Цена проволки</th>
        <th scope="col">Цена арматуры</th>
        <th scope="col">Цена сетки</th>
        <th scope="col">Цена бетона</th>
    </tr>
    </thead>
    <tbody class="table-striped">

    <#list pricesettings as pricesetting>
    <tr>
        <th scope="row">${pricesetting.pricedate}</th>
        <td>${pricesetting.wireprice}</td>
        <td>${pricesetting.armatureprice}</td>
        <td>${pricesetting.gridprice}</td>
        <td>${pricesetting.betonprice}</td>
    </tr>
    </#list>
    </tbody>
</table>



</@c.page>
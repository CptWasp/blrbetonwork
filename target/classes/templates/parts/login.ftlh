<#macro login path isRegisterForm>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-6 col-sm-8 col-10 mt-5">
            <form action="${path}" method="post" class="shadow-lg p-3 mb-5 bg-white rounded">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Фамилия Имя Отчество" />
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <#if !isRegisterForm><a class="btn btn-success" href="/registration">Зарегистриоваться</a></#if>
            <button type="submit" class="btn btn-primary"><#if isRegisterForm>Создать<#else>Войти</#if></button>
            </form>
        </div>
    </div>
</div>
</#macro>



<#macro logout>
<form action="/logout" method="post">
    <button type="submit" class="btn btn-danger">Выход</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>
</#macro>
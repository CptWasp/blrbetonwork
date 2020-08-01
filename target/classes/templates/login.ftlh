<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-6 col-sm-8 col-10 mt-5">
            <h2>Войти</h2>
        </div>
    </div>
</div>
<@l.login "/login" false/>
</@c.page>
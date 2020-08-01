<html>
<head>

</head>
<body>
    <div>
        <form method="post">
            <input type="date" name="proddate">
            <select name="prodname">
                <option value="Полимерный бетон">Полимерный бетон</option>
                <option value="Сверхлёгкий и Лёгкий бетон">Сверхлёгкий и Лёгкий бетон</option>
                <option value="Тяжёлый и сверхтяжёлый бетон">Тяжёлый и сверхтяжёлый бетон</option>
            </select>
            <input type="text" name="prodcount" placeholder="Количество продукта">
            <input type="text" name="mencount" placeholder="Количество человек">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <button type="submit">ДОбавить</button>
        </form>
    </div>



    <div>Список продуктов</div>

    {{#productions}}
    <div>
        <b>{{id}}</b>
        <b>{{proddate}}</b>
        <b>{{prodname}}</b>
        <b>{{prodcount}}</b>
        <b>{{mencount}}</b>
    </div>

    {{/productions}}
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <title>Calculadora</title>
</head>
<body>
    <h2>Calculadora</h2>

    <form action="divide" method="get">
        Dividendo: <input type="text" name="dividendo" /><br />
        Divisor: <input type="text" name="divisor" /><br />
        <input type="submit" value="Dividir" />
    </form>

    <p>${error}</p>
</body>
</html>

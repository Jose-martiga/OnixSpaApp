<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registrar Reserva - Ónix Spa</title>
</head>
<body>
    <h2>Registrar nueva reserva</h2>
    <form action="ReservaServlet" method="post">
        Nombre: <input type="text" name="nombreCliente" required><br>
        Servicio: <input type="text" name="servicio" required><br>
        Fecha: <input type="date" name="fecha" required><br>
        Hora: <input type="time" name="hora" required><br>
        <button type="submit">Registrar</button>
    </form>

    <p style="color:green;">
        ${mensaje}
    </p>
</body>
</html>

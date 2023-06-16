<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resposta de Cadastro</title>
</head>
<body>
    <h1>Resposta de Cadastro</h1>
    <h2>Informações Pessoais</h2>
    <p>
        <strong>Nome:</strong> <%= request.getParameter("nome") %><br>
        <strong>Email:</strong> <%= request.getParameter("email") %><br>
        <strong>Telefone:</strong> <%= request.getParameter("telefone") %><br>
    </p>

    <h2>Informações Acadêmicas</h2>
    <p>
        <strong>Instituição:</strong> <%= request.getParameter("instituicao") %><br>
        <strong>Curso:</strong> <%= request.getParameter("curso") %><br>
    </p>

    <h2>Informações Profissionais</h2>
    <p>
        <strong>Empresa:</strong> <%= request.getParameter("empresa") %><br>
        <strong>Cargo:</strong> <%= request.getParameter("cargo") %><br>
    </p>
</body>
</html>

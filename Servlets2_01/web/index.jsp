<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
        <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    </head>
    <body>

        <%@include file="WEB-INF/jspf/header.jspf" %>

        <div x-data="{
             aluno: null,
             getData(){
             fetch('seunome.json')
             .then(response => response.json())
             .then(json => this.aluno = json);
             }
             }" x-init="getData()">


            <table class="table table-dark">

                <tr>
                    <th>RA</th>
                    <th>Nome</th>
                </tr>
                <td x-text="aluno.RA"></td>
                <td x-text="aluno.Nome"></td>

            </table>

        </div>
    </body>
</html>

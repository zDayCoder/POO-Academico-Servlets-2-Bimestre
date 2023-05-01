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
             Data(){
             fetch('seunome.json')
             .then(response => response.json())
             .then(json => this.aluno = json);
             }
             }" x-init="Data()">


            <table class="table table-dark">

                <tr>
                    <th>Disciplina Cursadas</th>
                </tr>
                <template x-for="dis in aluno.Disciplina">
                    <tr><td x-text="dis"></td></tr>
                </template>

            </table>

        </div>

    </body>
</html>

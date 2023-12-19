<html>
    <head>
        <%@include file="head.jsp" %>
    </head>

    <body>
        <main>
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section class="border border-3 border-danger-subtle rounded-4 col-6 mx-auto text-center mt-4">
                    <h1 class="text-center my-4">Alta</h1>
                    <form method="post" action="<%=request.getContextPath()%>/CreateController">
                        <div class="my-3 mx-3">
                            <input name="nombreTextarea"  type="text" class="form-control" id="nombreTextarea" placeholder="Nombre" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                            <input name="apellidoTextarea" type="text" class="form-control" id="apellidoTextarea" placeholder="Apellido" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                            <input name="mailTextarea" type="mail" class="form-control" id="mailTextarea" maxlength="50" placeholder="Mail">
                        </div>
                        <div class="my-3 mx-3">
                            <input name="temaTextarea" type="text" class="form-control" id="temaTextarea" maxlength="50" placeholder="Tema">
                        </div>
                        <button class="btn my-3 "style="background-color: rgb(242,180,186)">
                            Dar de alta
                        </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>
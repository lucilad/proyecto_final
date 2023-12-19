<%@page import="com.codoacodo.dto.*"%>
<html>
    <head>
        <%@include file="head.jsp" %>	
    </head>

    <body>
        <main>
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section>
                    <%
                        Orador orador = (Orador) request.getAttribute("orador");
                    %>
                    <h1>Editar orador ID=<%=orador.getId()%></h1>
                     <form method="POST"
                          action="<%=request.getContextPath()%>/api/EditarController">
                        <div class="mb-3">
                            <label for="nombreTexarea" class="form-label">Nombre</label>
                            <input name="nombre"
                                   value="<%=orador.getNombre()%>"  
                                   type="text" class="form-control" id="nombreTextarea" placeholder="Nombre" maxlength="50">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Apellido</label>
                            <input name="nombre" 
                                   value="<%=orador.getApellido()%>"  
                                   type="text" class="form-control" id="apellidoTextarea" placeholder="Apellido" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                            <label for="mail" class="form-label">Mail</label>
                            <input value="<%=orador.getMail()%>" name="mailTextarea" type="mail" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="50">
                        </div>
                        <div class="mb-3">
                            <label for="temaTextarea" class="form-label">Tema</label>
                            <input value="<%=orador.getTema()%>" name="temaTextarea" type="text" class="form-control" id="temaTextarea" placeholder="Tema" maxlength="50">
                        </div>
                        <button class="btn btn-primary">
                            Grabar
                        </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>
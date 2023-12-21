<%@page import="com.codoacodo.dto.Orador"%>
<html>
    <head>
        <%@include file="head.jsp" %>	
    </head>

    <body class="bg-danger-subtle">
        <main>
            <%@include file="navbar.jsp" %>
            <div class="container mt-4 ">
                <section>
                    <%
                        Orador orador = (Orador) request.getAttribute("orador");
                    %>
                    <h1>Editar orador ID=<%=orador.getId()%></h1>
                     <form method="POST"
                          action="<%=request.getContextPath()%>/api/EditarController">
                         <div class="mb-3">
                              <label for="exampleFormControlInput1" class="form-label">ID</label>
                              <input name="id"
                                    value="<%=orador.getId()%>"  
                                    type="number" class="form-control" id="idEditar" placeholder="ID" maxlength="50" readonly="">
                            </div>
                        <div class="mb-3">
                            <label for="Nombre" class="form-label">Nombre</label>
                            <input name="nombre"
                                   value="<%=orador.getNombre()%>"  
                                   type="text" class="form-control" id="nombreEditar" placeholder="Nombre" maxlength="50">
                        </div>
                        <div class="mb-3">
                            <label for="Apellido" class="form-label">Apellido</label>
                            <input name="apellido" 
                                   value="<%=orador.getApellido()%>"  
                                   type="text" class="form-control" id="apellidoEditar" placeholder="Apellido" maxlength="50">
                        </div>
                        <div class="mb-3">
                            <label for="Mail" class="form-label">Mail</label>
                            <input value="<%=orador.getMail()%>" name="mail" type="mail" class="form-control" id="mailEditar" placeholder="Mail" maxlength="50">
                        </div>
                        <div class="mb-3">
                            <label for="Tema" class="form-label">Tema</label>
                            <input value="<%=orador.getTema()%>" name="tema" type="text" class="form-control" id="temaEditar" placeholder="Tema" maxlength="50">
                        </div>
                        <button class="btn btn-success">
                            Aceptar
                        </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Advocacia LCA - Listar Processos</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="components/menu.jsp"></c:import>
		<section class="container">
			<ol class="breadcrumb">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">Processo</a></li>
				<li><a href="ListaProcesso">Listar Processos</a></li>
				<li class="active">Listar Honor�rios</li>
			</ol>
			<article>
				<p class="bg-success text-success">
					<c:out value="${menssagem}"></c:out>
				</p>
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>N�mero do processo</th>
									<th>Descri��o do processo</th>
									<th>Advogado</th>
									<th>Tarefa</th>
									<th>Data</th>
									<th>Horas</th>
									<th>A��o</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaHonorario}" var="listagem">
									<tr>
										<td>${listagem.processo.numeroProcesso}</td>
										<td>${listagem.processo.descricao}</td>
										<td>${listagem.processo.advogado.nome}</td>
										<td>${listagem.tipoHonorario.descricao}</td>
										<td><fmt:formatDate value="${listagem.data.time}" pattern="dd/MM/yyyy" /></td>
										<td>${fn:replace(listagem.quantidadeHora, '.',':')}</td>
										<td><a href="AlteraHonorario?codigo=${listagem.codigo}&numeroProcesso=${listagem.processo.numeroProcesso}&cliente=${razaoSocial}&advogado=${listagem.processo.advogado.nome}&codigoHonorario=${listagem.tipoHonorario.codigo}"
											title="Editar"><span class="glyphicon glyphicon-pencil"></span></a>
											<a href="DeletaHonorario?codigo=${listagem.codigo}"
											title="Excluir"><span class="glyphicon glyphicon-remove"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</article>
		</section>
		<footer class="container">
			<div class="well well-sm">
				<small class="text-info">Advocacia LCA&reg; Todos os direitos
					reservados.</small>
			</div>
		</footer>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>

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
				<li class="active">Listar Despesas</li>
			</ol>
			<article>
				<p class="bg-success text-success">
					<c:out value="${mensagem}"></c:out>
				</p>
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Número do processo</th>
									<th>Descrição do processo</th>
									<th>Despesa</th>
									<th>Data</th>
									<th>Valor</th>
									<th>Ação</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaDespesas}" var="listagem">
									<tr>
										<td>${listagem.processo.numeroProcesso}</td>
										<td>${listagem.processo.descricao}</td>
										<td>${listagem.tipoDespesa.descricao}</td>
										<td><fmt:formatDate value="${listagem.data.time}" pattern="dd/MM/yyyy" /></td>
										<td>
											<fmt:setLocale value="pt-BR"/> 
											<fmt:parseNumber var="numeroFormatado" type="number" value="${fn:replace(listagem.valor, '.',',')}" />
											<fmt:formatNumber value="${numeroFormatado}" type="currency"/>	
           								</td>
										<td>
											<a href="AlteraDespesa?codigo=${listagem.codigo}&cliente=${razaoSocial}&codigoTipoDespesa=${listagem.tipoDespesa.codigo}&numeroProcesso=${listagem.processo.numeroProcesso}"
											title="Editar"><span class="glyphicon glyphicon-pencil"></span></a>
											<a href="DeletaDespesa?codigo=${listagem.codigo}&numeroProcesso=${listagem.processo.numeroProcesso}&cliente=${razaoSocial}"
											title="Excluir"><span class="glyphicon glyphicon-remove"></span></a>
										</td>
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
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>

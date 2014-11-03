<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li class="active">Lançar Honorario</li>
			</ol>
			<article>
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-horizontal" role="form" method="get"
							action="LancaHonorario">
							<div class="form-group">
								<label for="numeroProcesso" class="col-sm-2 control-label">Número
									do Processo:</label>
								<div class="col-md-7">
									<input type="text" class="form-control" id="numeroProcesso"
										name="numeroProcesso" value="${numeroProcesso}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="nomeCliente" class="col-sm-2 control-label">Nome
									do Cliente:</label>
								<div class="col-md-7">
									<input type="text" class="form-control" id="nomeCliente"
										name="nomeCliente" value="${cliente}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="tipoHonorario" class="col-sm-2 control-label">Honorário:</label>
								<div class="col-md-3">
									<select class="form-control" id="tipoHonorario" name="tipoHonorario">
										<option value=""></option>
										<c:forEach items="${listaTiposHonorario}" var="listaTipos">
											<option value="${listaTipos.codigo}">${listaTipos.descricao}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="dataHonorario" class="col-sm-2 control-label">Data
									Honorario:</label>
								<div class="col-md-7">
									<input type="date" class="form-control" id="dataHonorario"
										name="dataHonorario" required="required">
								</div>
							</div>
							<div class="form-group">
								<label for="quantidadeHora" class="col-sm-2 control-label">Quantidade horas:</label>
								<div class="col-md-7">
									<input type="text" class="form-control" id="quantidadeHora"
										name="quantidadeHora" required="required">
								</div>
							</div>
							<div class="form-group">
								<label for="observacaoHonorario" class="col-sm-2 control-label">Observações:</label>
								<div class="col-md-7">
									<textarea class="form-control" rows="2" name="observacao"
										id="observacaoHonorario"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-floppy-save"></span> Gravar
									</button>
								</div>
							</div>
						</form>
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

fviewSetting = function(id) {
	$.get("/content_sections/section", {
		id : id
	}, function(data) {
		$("#sections_content").html(data);
	});
}

fnSearchAction = function() {
	$.get("/content_sections/section_search", {
		title : $("#txtsearch").val()
	}, function(data) {
		$("#sections_content").html(data);
	});
}

fnDisabledSection = function(key) {
	console.log(key);
	$.get("/content_sections/disabled_detail", {
		id : key
	}, function(data) {
		console.log(data);
		$("#content-info").html(data);
	});
	fnRestaureEfectPopper();
	// $.post();
}

fnSearchDetalle = function(id, page) {
	console.log(id + " - " + page);
	$.get("/content_sections/listar_detalle_page", {
		id : id,
		page : page
	}, function(data) {
		$("#content-info").html(data);
	});
}

fnAplicarCambios = function() {
	$.post("/content_sections/aplicar_cambios", {
		"idrevisionValidacion" : $("#txtrevisionid").val(),
		"revision" : $("#txtrevision").val(),
		"detalle" : $('#txtdetalle').summernote('code'),
		"ayuda" : $('#txtayuda').summernote('code'),
		"descripcion" : $($('#txtdetalle').summernote('code')).text(),
		"idsubelemento.idsubelemento" : $("#txtidsubelemento").val()
	}, function(data) {
		$("#myModal").modal("hide");
		$.get("/content_sections/listar_detalle", {
			id : $("#txtidsubelemento").val()
		}, function(data) {
			$("#content-info").html(data);
		});
	});

	fnClearData();
}

fnRestaureEfectPopper=function(){
	$('[data-toggle="popover"]').popover('hide');
}

fnClearData = function() {
	$("#txtrevisionid").val(0);
	$("#txtdetalle").summernote('reset');
	$("#txtayuda").summernote('reset');
	$("#txtrevision").val("");
}

fnOpenModal = function() {
	$("#myModal").modal({
		backdrop : 'static',
		keyboard : false,
		show : true
	});
}

fnCloseModal = function() {
	$("#myModal").modal('hide');
	fnClearData();
}

fnLoadSection = function(id) {

	if (id == 0) {
		return;
	}
	// $("#txtdetalle").summernote("disable");
	// $("#txtayuda").summernote("disable");
	$("#txtrevisionid").val(id);
	$.ajax({
		type : "GET",
		dataType : "json",
		url : "/content_sections/section_load/" + id,
		data : $(this).serialize(),
		success : function(data) {
			$("#txtrevision").val(data.revision);
			$("#txtdetalle").summernote('code', data.detalle);
			$("#txtayuda").summernote('code', data.ayuda);
			fnOpenModal();
		}
	});

}

sendFile = function(file, el) {
	var form_data = new FormData();
	form_data.append('file', file);
	$.ajax({
		data : form_data,
		type : "post",
		url : '/contents/image_uploads',
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			var index_files = 0;
			if (!isNaN(data.files.length - 1)) {
				index_files = parseInt(data.files.length) - 1;
			}
			$(el).summernote('editor.insertImage', data.files[index_files]);
		}
	});

};





//////////////////////////////////////////////////////////////////

fnAplicarCambios = function(){
	
	
	if($("#cboPerfil").val()<0){
		alert("elija el perfil");
	}
	
	
	var objecto = {
		"idusuario":$("#txtIdUser").val(),
		"nombres":$("#txtNombre").val(),
		"apellidos":$("#txtApellido").val(),
		"matricula":$("#txtMatricula").val(),
		"username":$("#txtUsuario").val(),
		"password":$("#txtPassword").val(),
		"estado":$("#chkEstado").is(":checked"),
		"perfil.idperfil":$("#cboPerfil").val()
	} 
	
	$.ajax({
		data:objecto,
		type: "post",
		url : "/setting/aplicar_cambios",
		cache:false,
		success:function(data){
			alert(data.exito);
			listar_usuarios();	
		},
		error:function(data){
			
		}
	});
	
	
	$("#txtIdUser").val("0");
}

listar_usuarios = function(){
	$.post("/setting/listar",{},function(data){
		$("#data_user").html(data);
	});
}














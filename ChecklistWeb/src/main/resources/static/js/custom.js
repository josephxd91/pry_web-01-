var fviewSetting = function(id) {
	$.get("/content_sections/section", {
		id : id
	}, function(data) {
		$("#sections_content").html(data);
	});
}

var fnSearchAction = function() {
	$.get("/content_sections/section_search", {
		title : $("#txtsearch").val()
	}, function(data) {
		$("#sections_content").html(data);
	});
}

var fnDisabledSection = function(key) {
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

var fnSearchDetalle = function(id, page) {
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

var fnRestaureEfectPopper = function() {
	$('[data-toggle="popover"]').popover('hide');
}

var fnClearData = function() {
	$("#txtrevisionid").val(0);
	$("#txtdetalle").summernote('reset');
	$("#txtayuda").summernote('reset');
	$("#txtrevision").val("");
}

var fnOpenModal = function() {
	$("#myModal").modal({
		backdrop : 'static',
		keyboard : false,
		show : true
	});
}

var fnCloseModal = function() {
	$("#myModal").modal('hide');
	fnClearData();
}

var fnLoadSection = function(id) {

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

var sendFile = function(file, el) {
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

// ////////////////////////////////////////////////////////////////

fnAplicarCambios = function() {

	if ($("#cboPerfil").val() < 0) {
		alert("elija el perfil");
	}

	var object = {
		"idusuario" : $("#txtIdUser").val(),
		"nombres" : $("#txtNombre").val(),
		"apellidos" : $("#txtApellido").val(),
		"matricula" : $("#txtMatricula").val(),
		"username" : $("#txtUsuario").val(),
		"password" : $("#txtPassword").val(),
		"estado" : $("#chkEstado").is(":checked"),
		"perfil.idperfil" : $("#cboPerfil").val()
	}

	$.ajax({
		data : object,
		type : "post",
		url : "/setting/aplicar_cambios",
		cache : false,
		success : function(data) {
			alert(data.exito);
			listar_usuarios();
		},
		error : function(data) {

		}
	});

	$("#txtIdUser").val("0");
}

listar_usuarios = function() {
	$.post("/setting/listar", {}, function(data) {
		$("#data_user").html(data);
	});
}

fn_load_page_local = function() {
	$.post("/setting/page_local", {}, function(data) {
		$("#load_content").html(data);
	})
}

fn_load_page_user = function() {
	$.post("/setting/page_user", {}, function(data) {
		$("#load_content").html(data);
	})
}

fn_validate_folder_shared = function() {
	$.post("/setting/validateFolderShared", {
		"folder" : $("#txtRutaCompleta").val(),
		"hostname" : $("#txtHostName").val()
	}, function(data) {
		console.log(data.error)

		if (data.error == null) {
			$("#mensaje_1").attr("class", "valid-feedback");
			$("#mensaje_1").text(data.exito);
			$("#txtHostName").attr("class", "form-control is-valid");
		} else {
			$("#mensaje_1").attr("class", "invalid-feedback");
			$("#mensaje_1").text(data.error);
			$("#txtHostName").attr("class", "form-control is-invalid");
		}
	});

}

// ///revision

var fviewOption = function(id) {
	console.log("id  => " + id);
	$.get("/revision/info", {
		id : id
	}, function(data) {
		$("#sections_content").html(data);
	});

	
}


var fnCambiarEstadoCheckList = function(id){
	var cumple = $(".cboCumpleValidacion.custom-select").val();
	console.log("id => "  + id + " - cumple ?" + cumple );
	
	
	
}

// fnLoadCheckList = function(){
// $.post("revision/ajax/listado.html",{},function(data){
// console.log(data);
// });
// }

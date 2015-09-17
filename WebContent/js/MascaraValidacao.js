function validarCampo(obj) {
	var selecionado = document.getElementById("tipoDeBusca");

	if(selecionado == null){

		var cpf = obj.value;
		exp = /\.|\-/g;
		cpf = cpf.toString().replace(exp, "");
		var digitoDigitado = eval(cpf.charAt(9) + cpf.charAt(10));
		var soma1 = 0, soma2 = 0;
		var vlr = 11;

		for (i = 0; i < 9; i++) {
			soma1 += eval(cpf.charAt(i) * (vlr - 1));
			soma2 += eval(cpf.charAt(i) * vlr);
			vlr--;
		}
		soma1 = (((soma1 * 10) % 11) == 10 ? 0 : ((soma1 * 10) % 11));
		soma2 = (((soma2 + (2 * soma1)) * 10) % 11);

		var digitoGerado = (soma1 * 10) + soma2;
		if (digitoGerado != digitoDigitado) {
			alert('CPF Inválido!');
		}
	
	}else{
		for (i = 0; i < selecionado.length; i++) {
	
			if (selecionado[i].checked == true) {
				if (selecionado[i].value == 'cpf') {
					var cpf = obj.value;
					exp = /\.|\-/g;
					cpf = cpf.toString().replace(exp, "");
					var digitoDigitado = eval(cpf.charAt(9) + cpf.charAt(10));
					var soma1 = 0, soma2 = 0;
					var vlr = 11;
	
					for (i = 0; i < 9; i++) {
						soma1 += eval(cpf.charAt(i) * (vlr - 1));
						soma2 += eval(cpf.charAt(i) * vlr);
						vlr--;
					}
					soma1 = (((soma1 * 10) % 11) == 10 ? 0 : ((soma1 * 10) % 11));
					soma2 = (((soma2 + (2 * soma1)) * 10) % 11);
	
					var digitoGerado = (soma1 * 10) + soma2;
					if (digitoGerado != digitoDigitado) {
						alert('CPF Inválido!');
					}
				} else if (selecionado[i].value == 'data') {
					exp = /\d{2}\/\d{2}\/\d{4}/;
					if (!exp.test(obj.value)) {
						alert('Data Inválida!');
					}
				}
			}
		}
	}
}

function keyPress(e, obj) {
	
//	 var unicode = e.charCode ? e.charCode : e.keyCode;
//		if (unicode == 8) { //if the key isn't the backspace key (which we should allow)
//			return true;
//		}else if (unicode < 48 || unicode > 57) { //if not a number
//			if (unicode != 8) { //if the key isn't the backspace key (which we should allow)
//				return false; //disable key press
//			}
//		}
//	
	var selecionado = document.forms[0].tipoDeBusca;
		
	if(selecionado == null){
			
		var unicode = e.charCode ? e.charCode : e.keyCode;
		if (unicode != 8) { //if the key isn't the backspace key (which we should allow)
			if (unicode < 48 || unicode > 57) { //if not a number
				return false; //disable key press
			}
		}

		obj.maxLength = '14';
		if (obj.value.length == 3) {
			obj.value += '.';
		}
		if (obj.value.length == 7) {
			obj.value += '.';
		}
		if (obj.value.length == 11) {
			obj.value += '-';
		}
	
	}else{
		for (i = 0; i < selecionado.length; i++) {
	
			if (selecionado[i].checked == true) {
				if (selecionado[i].value == 'cpf') {
					var unicode = e.charCode ? e.charCode : e.keyCode;
					if (unicode != 8) { //if the key isn't the backspace key (which we should allow)
						if (unicode < 48 || unicode > 57) { //if not a number
							return false; //disable key press
						}
					}
	
					obj.maxLength = '14';
					if (obj.value.length == 3) {
						obj.value += '.';
					}
					if (obj.value.length == 7) {
						obj.value += '.';
					}
					if (obj.value.length == 11) {
						obj.value += '-';
					}
				} else if (selecionado[i].value == 'data') {
					var unicode = e.charCode ? e.charCode : e.keyCode
					if (unicode != 8) { //if the key isn't the backspace key (which we should allow)
						if (unicode < 48 || unicode > 57) { //if not a number
							return false; //disable key press
						}
					}
					obj.maxLength = '10';
					if (obj.value.length == 2) {
						obj.value += '/';
					}
					if (obj.value.length == 5) {
						obj.value += '/';
					}
				}
			}
		}
	}
}
package util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
 
public class FileUploadForm extends ActionForm{
 
	private FormFile file;
 
	public FormFile getFile() {
		return file;
	}
 
	public void setFile(FormFile file) {
		this.file = file;
	}
 
	@Override
	public ActionErrors validate(ActionMapping mapping,
	   HttpServletRequest request) {
 
	    ActionErrors errors = new ActionErrors();
 
	    if( getFile().getFileSize()== 0){
	      request.setAttribute("mensagem", "Nenhum arquivo selecionado");
	       return errors;
	    }
 
	    //only allow textfile to upload
	    if(!"text/plain".equals(getFile().getContentType())){
	        errors.add("common.file.err.ext",
	    	 new ActionMessage("error.common.file.textfile.only"));
	        request.setAttribute("mensagem", "Arquivo inválido");
	        return errors;
	    }
 
            //file size cant larger than 16mb
	    System.out.println(getFile().getFileSize());
	    if(getFile().getFileSize() > 16777216){ //16mb
	       errors.add("common.file.err.size",
		    new ActionMessage("error.common.file.size.limit", 10240));
	       request.setAttribute("mensagem", "Tamanho máximo do arquivo é 16mb");
	       return errors;
	    }
 
	    return errors;
	}
}
var release = "7,0,19,0"; 
function flashsrc(swf,flashVarString,w,h,bgcolor,menu,mode,q,id){ 
     document.write('<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" ' 
     +'codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version='+release+'" ' 
     +'width="'+w+'" height="'+h+'" id="'+id+'" align="">' 
     +'<param name="movie" value="'+swf+'">' 
     +'<param name="menu" value="'+menu+'"> ' 
     +'<param name="quality" value="'+q+'"> ' 
     +'<param name="wmode" value="'+mode+'"> ' 
     +'<param name="bgcolor" value="'+bgcolor+'"> ' 
     +'<param name="flashvars" value="'+flashVarString+'"> ' 
     +'<embed src="'+swf+'" flashvars="'+flashVarString+'" menu="'+menu+'" quality="'+q+'" wmode="'+mode+'" ' 
     +' bgcolor="'+bgcolor+'"  width="'+w+'" height="'+h+'" name="'+swf+'" ' 
     +' align=""  type="application/x-shockwave-flash" ' 
     +' pluginspage="http://www.macromedia.com/go/getflashplayer"></embed></object> '); 
  
} 
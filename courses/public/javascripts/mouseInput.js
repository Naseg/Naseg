/* mouse move */
/*
document.onmousemove = mouseMove; 

function mouseMove(ev){ 
    ev           = ev || window.event; 
    var mousePos = mouseCoords(ev); 
} 

function mouseCoords(ev){ 
    if(ev.pageX || ev.pageY){ 
        return {x:ev.pageX, y:ev.pageY}; 
    } 

    return { 
        x:ev.clientX + document.body.scrollLeft - document.body.clientLeft, 
        y:ev.clientY + document.body.scrollTop  - document.body.clientTop 
    };

}

/* mouse button */
/*
var dragObject     = null;

document.onmouseup = mouseUp; 
 
function makeClickable(object){ 
    object.onmousedown = function(){ 
        dragObject = this; 
    } 
} 

function mouseUp(ev){ 
    dragObject = null; 
} 
*/

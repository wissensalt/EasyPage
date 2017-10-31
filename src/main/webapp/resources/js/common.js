/**
 * Created by Ladies Man on 1/15/2016.
 */

function displayAlert(data){
    if(confirm('Are you sure to delete ' + data)){
        return true;
    }else{
        return false;
    }

}


$(document).ready(function(){
    $('#menuItem').ready(function () {
       var key = $(this).data('key');
        displayAlert(key);
    });
});
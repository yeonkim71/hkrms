function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
function gridLoader(boolChk, type) {
    if(boolChk) {
        if(typeof type !== 'undefined' && type === 'small') {
            $('<div id="loading" class="loading"></div><img id="loading_img_small" alt="loading" src="/image/loading1.gif" style="width:70px;height:70px;">').appendTo(document.body);
        } else {
            $('<div id="loading" class="loading"></div><img id="loading_img" alt="loading" src="/image/loading1.gif">').appendTo(document.body);
        }
    } else {
        $('#loading').remove();
        $('#loading_img').remove();
        $('#loading_img_small').remove();
    }
}
function unformat(str) {
    return String(str).replace(/[^0-9]/gi,'');
}
var popup = null;
function openPopupNew(targetId,popupWindowName,popupUrl,UpdateFields_BizNo,wid,hei) {
    $targetData = unformat($('#'+targetId).val());
    popup = window.open(popupUrl+'?dataType1='+targetId+'&data1='+$targetData+'&callback='+UpdateFields_BizNo, popupWindowName, 'width='+wid+',height='+hei);
}

$(function() {
    $('input[type=text]').each(function() {
        $(this).bind('click, focus', function() {
            if( $(this).hasClass('input-readonly') ) {
                $(this).blur();
            }
        });

    });
});
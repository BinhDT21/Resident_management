//chuyen trang thai resident 
function deleteResident(url) {
    fetch(url, {
        method: 'delete'
    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
};

//chuyen trang thai feedback
function solveFeedback(url) {
    
    fetch(url, {
        method: 'delete'
    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
};

//chuyen trang thai survey
function blockSurvey(url) {
    
    fetch(url, {
        method: 'delete'
    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
};

//chuyen trang thai visitor
function deleteVisitor(url) {
    
    fetch(url, {
        method: 'delete'
    }).then(res => {
        if (res.status === 204)
        {
            alert("Xóa thành công !")
            location.reload();
        }
        else
            alert("ERROR");
    });
};


//xoa item
function deleteItem(url) {
    
    fetch(url, {
        method: 'delete'
    }).then(res => {
        if (res.status === 204)
        {
            alert("Xóa thành công !")
            location.reload();
        }
        else
            alert("ERROR");
    });
};
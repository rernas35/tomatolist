// index.js

var root = document.body

var tomatoArray = new Array();
var responseCode = "";
var description = "";

var getTomatoData = function() {
    m.request({
        method: "GET",
        url: "/data?size=" +  ((document.getElementById("size_input") ) ? (document.getElementById("size_input").value) : "10" ),
        withCredentials: false,
    })
    .then(function(data) {
        if (data.body != null)
            tomatoArray = data.body;
        else 
            tomatoArray = new Array();
        responseCode=data.responseCode;
        description=data.description;
    })
}

var formatDate = function(date){
    var dd = date.getDate();
    var mm = date.getMonth();
    var yyyy = date.getFullYear();

    if (dd < 10)
        dd = "0" + dd;
    if (mm < 10)
        mm = "0" + mm;
    return dd + "." + mm + "." + yyyy;
}


var TomatoTable = {
    oninit: getTomatoData(10),
    view: function() {
        return m("main", [
            m("div",[m("span", "Size:"),
                     m("input", {id:"size_input"}),
                     m("button", {
                        onclick: getTomatoData
                     }, "Refresh")]),
            m("table",
                        [m("th","Provider"),
                         m("th","Tometoes"),
                         m("th","Sale Date")],
                        tomatoArray.map(function(tomatoItem){ 
                                            return  m("tr",[m("td",tomatoItem.provider),
                                                            m("td",tomatoItem.tomatoes),
                                                            m("td",formatDate(new Date(tomatoItem.timestamp)))]) }),
                        m("tr",[m("td",{colspan:3},responseCode + "-" + description)])
            ,{id:"tomato_table"})

        ])
    }
}

m.mount(root, TomatoTable)
var sizeInput = document.getElementById("size_input").value;
module.exports = app => {

    app.get('/', function(req, resp) {
        resp.render('home/index');
    });

}


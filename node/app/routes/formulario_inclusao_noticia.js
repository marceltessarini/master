module.exports = app => {

    app.get('/formulario_inclusao_noticia', function(req, resp) {
        resp.render('admin/form_add_noticia');
    });

}


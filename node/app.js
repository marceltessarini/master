let app = require('./config/server');
let rotaNoticias = require('./app/routes/noticias');
let rotaHome = require('./app/routes/home');
let rotaFormularioInclusaoNoticias = require('./app/routes/formulario_inclusao_noticia');

rotaNoticias(app);
rotaHome(app);
rotaFormularioInclusaoNoticias(app);

app.listen(3000, function() {
    console.log('Servidor rotando.');
});
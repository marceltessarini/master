let http = require('http');

console.log('Iniciando servidor.');
// let server = http.createServer(function (req, resp) {

let server = http.createServer((req, resp) => {


    let categoria = req.url;

    if (categoria == '/tecnologia') {
        resp.end('<html><body>Notícias sobre Tecnologia.</body></html>')
    } else if (categoria == '/moda') {
        resp.end('<html><body>Notícias sobre Moda.</body></html>')
    } else if (categoria == '/beleza') {
        resp.end('<html><body>Notícias sobre Beleza.</body></html>')
    } else {
        resp.end('<html><body>Portal de Notícias</body></html>')
    }


});

server.listen(3000);
console.log('Servidor iniciado.');

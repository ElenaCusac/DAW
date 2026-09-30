import 'bootstrap/dist/css/bootstrap.min.css';
import { Component } from 'react';
import { Card, CardBody, CardTitle, CardSubtitle, CardText, Col, Button, Modal, ModalHeader, ModalFooter, ModalBody, Navbar, Nav, Badge, Row } from 'reactstrap';

function VentanaModal(props) {
    return (
        <div>
            <Modal isOpen={props.mostrar} toggle={props.toggleModal} >
                <ModalHeader toggle={props.toggleModal}>TITULO PASADO POR PROPS</ModalHeader>
                <ModalBody>
                    BOCADILLO ----- 8 <Button color="success">+</Button><Button color="danger">-</Button>
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" onClick={props.toggleModal}>
                        Aceptar texto por props
                    </Button>{' '}
                </ModalFooter>
            </Modal>
        </div>
    );
}

const Producto = (props) => {
    return (
        props.listaProductos.map((producto) => {
            return (
                <Col md="4" key={producto.id}>
                    <Card style={{ width: '18rem' }}>
                        <img alt="cafetería la Mari" src={producto.imagen} width="285" height="200" />
                        <CardBody>
                            <CardTitle tag="h5">
                                {producto.titulo}
                            </CardTitle>
                            <CardSubtitle className="mb-2 text-muted" tag="h6">
                                {producto.subtitulo}
                            </CardSubtitle>
                            <CardText>
                                {producto.texto}
                            </CardText>
                            <Button color="warning" onClick={() => props.sumar(producto.id, 1)}>
                                Añadir al pedido
                            </Button>
                        </CardBody>
                    </Card>
                </Col>
            )
        })
    )
}

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isOpen: false,
            productos: [
                {
                    id: 1,
                    titulo: "Café",
                    imagen: "https://cdn.pixabay.com/photo/2020/09/21/05/57/coffee-5589036_1280.jpg",
                    subtitulo: "Café recién molido",
                    texto: "Una taza de café aromático elaborado con granos seleccionados para empezar bien el día.",
                    carrito: 0
                },
                {
                    id: 2,
                    titulo: "Tostada",
                    imagen: "https://img-global.cpcdn.com/recipes/d2238d5a3e8ab530/680x781f0.56303_0.463404_1.36018q80/tostada-crujiente-de-aguacate-foto-principal.jpg",
                    subtitulo: "Tostada crujiente",
                    texto: "Deliciosa tostada de pan artesano, acompañada de aceite de oliva virgen extra o mantequilla.",
                    carrito: 0
                },
                {
                    id: 3,
                    titulo: "Refresco",
                    imagen: "https://images.stockcake.com/public/a/c/b/acb75fb8-a212-4593-9c2c-2a2ec10c1503_large/colorful-drinks-toast-stockcake.jpg",
                    subtitulo: "Bebida refrescante",
                    texto: "Refresco frío ideal para acompañar cualquier comida o para disfrutar en un descanso.",
                    carrito: 0
                }
            ],
            contador: 0,
            listaProductos: []
        }
    }

    toggleModal() {
        this.setState({ isOpen: !this.state.isOpen })
    };

    suma(idProducto, n) {
        let contador = this.state.contador;
        let prods = this.state.productos.map(e => {
            if (e.id == idProducto) {
                e.carrito += n;
                contador += n;
            }
            return e;
        })

        this.setState({ productos: prods, contador: contador })

    }

    render() {
        return (
            <div className="App">
                <Navbar>
                    <Nav className="me-auto" navbar>
                        <Button color="primary" onClick={() => this.toggleModal()}>
                            Carrito{" "}
                            <Badge color="danger"> {this.state.contador} </Badge>
                        </Button>
                    </Nav>
                </Navbar>
                <Row><Producto listaProductos={this.state.productos} sumar={(idProducto, n) => this.suma(idProducto, n)} /></Row>
                <VentanaModal mostrar={this.state.isOpen} toggleModal={() => this.toggleModal()} carrito={this.state.listaProductos} />
            </div>
        );
    }
}

export default App;
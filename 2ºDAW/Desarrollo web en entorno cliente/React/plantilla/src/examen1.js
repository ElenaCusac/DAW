import React, { Component } from 'react';
import {
    CardBody, Card, CardTitle, CardSubtitle, ListGroupItem,
    ListGroup, Row, Col, Container
} from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { RAS } from './componentes/datos.js'
class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            listaRas: RAS,
        }
    }
    render() {
        return (
            <div className="App">
                <VisualizadorRAS lista={this.state.listaRas} />
            </div>
        );
    }
}
const VisualizadorRAS = (props) => {
    let lista = JSON.parse(JSON.stringify(props.lista));
    let numRA = 0

    return lista["resultadosAprendizaje"].map((ra) => <RA key={numRA += 1} ra={ra}></RA>);

}
const RA = (props) => {
    let ra = props.ra;

    return (
        <Container className="my-4" >
            <Row xs="1" sm="2" md="3" lg="4" className="g-4">
                <Col>
                    <Card className="h-100" >
                        <CardBody>
                            <CardTitle tag="h5">{ra.id}</CardTitle>
                            <CardSubtitle className="mb-2 text-muted" tag="h6">
                                {ra.descripcion}
                            </CardSubtitle>
                            <ListGroup flush>
                                {
                                    ra.criteriosEvaluacion.map((criterio) => {
                                        return (
                                            <ListGroupItem>
                                                {criterio.letra.toUpperCase()}. {criterio.descripcion}
                                            </ListGroupItem>
                                        );

                                    })
                                }
                            </ListGroup>
                        </CardBody>
                    </Card>
                </Col>
            </Row>
        </Container >
    );
}
export default App;
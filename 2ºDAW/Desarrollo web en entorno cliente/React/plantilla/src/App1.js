import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            saludo: "ESTA APLICACIÓN SALUDA AL USUARIO."
        }
    }

    mensaje(mensaje) {
        this.setState({saludo: mensaje})
    }

    render() {
        return (
            <div className="App">
                <h1>{this.state.saludo}</h1>
                <Button color="primary" onClick={()=>this.mensaje("HELLO")}> INGLÉS </Button> 
                <Button color="success" onClick={()=>this.mensaje("HALLO")}> ALEMAN </Button> 
                <Button color="warning"onClick={()=>this.mensaje("HELJ")}> SUECO </Button> 
                <Button color="danger"onClick={()=>this.mensaje("HOLA")}> ESPAÑOL </Button>
            </div>
        )
    }
}

export default App;

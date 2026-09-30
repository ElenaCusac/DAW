//import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            listaBotones: Array(9).fill(null).map(e => Array(9).fill("-")),
            listaColores: ["primary", "danger"],
            turno: true,
            jugable: true,
        }
    }

    findPos(y) {
        let l = this.state.listaBotones;

        for (let i = 0; i < 9; i++) {
            console.log()
            if (l[i][y] != "-") return i - 1
        }

        return 8
    }

    clica(x, y) {
        if (x !== 0) return;

        console.log("Columna " + y)
        console.log("Posicion " + this.findPos(y))

        let l = this.state.listaBotones;
        let p = this.findPos(y)

        if (p >= 0) {
            if (this.state.turno) {
                l[p][y] = this.state.listaColores[0]
            } else {
                l[p][y] = this.state.listaColores[1]
            }

        }

        this.setState({ listaBotones: l, turno: !this.state.turno })
    }

    render() {
        return (
            <div className="App">
                <MapaBotones clica={(x, y) => this.clica(x, y)} listaBotones={this.state.listaBotones} alClicar={() => this.clicarBoton()} />
            </div>
        );
    }
}

const MapaBotones = (props) => {
    // este componente visualiza todos los botones del juego
    // parametros listaBotones
    // evitar warnings por keys
    let lista = [];
    props.listaBotones.map((fila, i) => {
        //console.log(fila)
        fila.map((columna, j) => {
            if (columna == "-") {
                lista.push(<Button key={i * 10 + j} outline onClick={() => props.clica(i, j)}>{"   "}</Button>)
            } else {
                lista.push(<Button key={i * 10 + j} color={columna} >{"   "}</Button>)
            }
        })
        lista.push(<br key={"br" + i} />)
    })
    return (
        lista
    )
}

const cambiaColor = (props) => {

}

export default App;
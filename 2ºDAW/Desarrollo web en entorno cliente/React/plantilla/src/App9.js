import 'bootstrap/dist/css/bootstrap.min.css';
import { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      deseos: ["Gambas", "Jamón"]
    };
  }

  handleAniadirDeseo(event) {
    event.preventDefault();
    let aux = this.state.deseos.slice(); // 1.

    if (!this.state.deseos.find((deseo) => deseo.toLowerCase() === event.target.deseo.value.toLowerCase())) {
      aux.push(event.target.deseo.value); // 2.
      this.setState({ deseos: aux }); // 3. 
    }

    /*
    Para cambiar el estado, tengo que hacer 3 cosas:

      1. Hago una copia.
      2. Modifico la copia.
      3. Actualizo el estado con setState.
    */
  }

  render() {
    return (
      <div className="App">
        <h1>LISTA DE DESEOS</h1>

        <div>
          <p><strong>Añade tu regalo favorito</strong></p>
        </div>

        <DesireList deseos={this.state.deseos} />
        <Desire onAddDeseo={this.handleAniadirDeseo.bind(this)} />
      </div>
    );
  }
}

const PrintDeseo = (props) => {
  return (
    <li>{props.deseo}</li>
  );
};

class DesireList extends Component {
  render() {
    return (
      <ul>
        {
          this.props.deseos.map(
            (d, i) => <PrintDeseo key={i} deseo={d} />
          )
        }
      </ul>
    );
  }
}

class Desire extends Component {
  render() {
    return (
      <form onSubmit={this.props.onAddDeseo}>
        <input type="text" placeholder="Escribe tu deseo" name="deseo"/>
      </form>
    );
  }
}

export default App;
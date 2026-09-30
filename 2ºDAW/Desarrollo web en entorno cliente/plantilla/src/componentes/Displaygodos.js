import Flashcard from "./FlashcardComponent";

const DisplayGodos = (props) => {
    const losreyes = props.reyes;
    const lista = losreyes.map((rey) =>
        <Flashcard key={rey.id.toString()}  imagen={rey.imagen} titulo={rey.nombre} texto={rey.texto} tipoRey={rey.tipoRey}/>);
    return (
        <ul>{lista}</ul>
    );
}

export default DisplayGodos;
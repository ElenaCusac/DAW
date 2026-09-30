const UserForm = (props) => {
    return (
        <form onSubmit={props.onAddUser}>
            <input type="text" placeholder="Nombre" name="nombre" />
            <input type="email" placeholder="Email" name="email" />
            <input type="submit" value="Guardar" />
        </form>
    )
}
export default UserForm
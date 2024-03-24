> ## How can a newcomer add a new command?
>To add a new command, a newcomer needs to follow these steps:

> - Open the CommandChecker class.
> - Add a new if condition in the createCommand method to recognize the new command name.
> - Inside the if block, instantiate the corresponding command class.
> - Implement the new command by creating a new class that implements the Command interface.
> - Write the logic for the new command inside its respective class.

> ## How can a newcomer add a new file-based data source?
> To add a new file-based data source, a newcomer should:

> - Create a new class that implements the TodoInterfaceStorage interface.
> - Implement the required methods (listTodos and insertTodo) to handle reading from and writing to the new file format.
> - Optionally, update the TodoCheckFilename class to recognize the new file extension and return the appropriate storage instance.

> ## How can a newcomer add a non-file-based data source?
> To add a non-file-based data source, a newcomer can:

> - Follow the steps to create a new file-based data source.
> - Instead of reading from or writing to files, implement the methods to interact with the non-file-based data source (e.g., a database, an API).

> ## How can a newcomer add a new attribute to a Todo?
> To add a new attribute to a Todo, a newcomer should:

> - Open the Todo class.
> - Add a new private field to represent the new attribute.
> - Create getter and setter methods for the new attribute.
> - Update any relevant methods to handle the new attribute if necessary.

> ## How can a newcomer add a new interface to the project?
> To add a new interface to the project, a newcomer needs to:

> - Create a new Java interface file in the appropriate package.
> - Define the methods that the interface will declare.
> - Implement the interface in one or more classes as needed.
> - Ensure that any classes implementing the interface provide concrete implementations for all its methods.
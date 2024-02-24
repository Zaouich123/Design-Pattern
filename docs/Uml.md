classDiagram
direction BT
class App {
  + main(String[]) void
  + exec(String[]) int
}
class CommandeParser {
  + parse(String[]) CommandLine
}
class CsvFileManager {
  + readCsvFile(String) List~String~
  + writeCsvFile(String, String) void
}
class CsvTodoReader {
  + readTodos(String) List~Todo~
}
class CsvTodoStorage {
  + insertTodo(String, Todo) void
  + listTodos(String, boolean) void
}
class CsvTodoWriter {
  + writeTodo(String, Todo) void
}
class FileClass {
  + writeFileContent(String, String) void
  + readFileContent(String) String
}
class JsonFileManager {
  + writeJsonFile(Path, JsonNode) void
  + readJsonFile(Path) JsonNode
}
class JsonTodoReader {
  + readTodos(String) List~Todo~
}
class JsonTodoStorage {
  + listTodos(String, boolean) void
  + insertTodo(String, Todo) void
}
class JsonTodoWriter {
  + writeTodo(String, Todo) void
}
class MigrateCsvToCsv {
  + migrate(String, String) void
}
class MigrateCsvToJson {
  + migrate(String, String) void
}
class MigrateJsonToCsv {
  + migrate(String, String) void
}
class MigrateJsonToJson {
  + migrate(String, String) void
}
class MigrationInterface {
<<Interface>>
  + migrate(String, String) void
}
class Todo {
  + setText(String) void
  + isDone() boolean
  + getText() String
  + toString() String
}
class TodoCheckFilename {
  + createTodoChecker(String) TodoInterfaceStorage
}
class TodoInterfaceStorage {
<<Interface>>
  + listTodos(String, boolean) void
  + insertTodo(String, Todo) void
}

App  ..>  Todo : «create»
CsvTodoReader "1" *--> "csvFileManager 1" CsvFileManager 
CsvTodoReader  ..>  CsvFileManager : «create»
CsvTodoReader  ..>  Todo : «create»
CsvTodoStorage  ..>  CsvTodoReader : «create»
CsvTodoStorage "1" *--> "csvTodoReader 1" CsvTodoReader 
CsvTodoStorage  ..>  CsvTodoWriter : «create»
CsvTodoStorage "1" *--> "csvTodoWriter 1" CsvTodoWriter 
CsvTodoStorage  ..>  TodoInterfaceStorage 
CsvTodoWriter "1" *--> "csvFileManager 1" CsvFileManager 
CsvTodoWriter  ..>  CsvFileManager : «create»
JsonTodoReader  ..>  JsonFileManager : «create»
JsonTodoReader "1" *--> "jsonFileManager 1" JsonFileManager 
JsonTodoReader  ..>  Todo : «create»
JsonTodoStorage "1" *--> "jsonTodoReader 1" JsonTodoReader 
JsonTodoStorage  ..>  JsonTodoReader : «create»
JsonTodoStorage "1" *--> "jsonTodoWriter 1" JsonTodoWriter 
JsonTodoStorage  ..>  JsonTodoWriter : «create»
JsonTodoStorage  ..>  TodoInterfaceStorage 
JsonTodoWriter  ..>  JsonFileManager : «create»
JsonTodoWriter "1" *--> "jsonFileManager 1" JsonFileManager 
MigrateCsvToCsv  ..>  CsvTodoReader : «create»
MigrateCsvToCsv "1" *--> "csvTodoReader 1" CsvTodoReader 
MigrateCsvToCsv  ..>  CsvTodoWriter : «create»
MigrateCsvToCsv "1" *--> "csvTodoWriter 1" CsvTodoWriter 
MigrateCsvToCsv  ..>  MigrationInterface 
MigrateCsvToJson  ..>  CsvTodoReader : «create»
MigrateCsvToJson "1" *--> "csvTodoReader 1" CsvTodoReader 
MigrateCsvToJson "1" *--> "jsonTodoWriter 1" JsonTodoWriter 
MigrateCsvToJson  ..>  JsonTodoWriter : «create»
MigrateCsvToJson  ..>  MigrationInterface 
MigrateJsonToCsv "1" *--> "csvTodoWriter 1" CsvTodoWriter 
MigrateJsonToCsv  ..>  CsvTodoWriter : «create»
MigrateJsonToCsv  ..>  JsonTodoReader : «create»
MigrateJsonToCsv "1" *--> "jsonTodoReader 1" JsonTodoReader 
MigrateJsonToCsv  ..>  MigrationInterface 
MigrateJsonToJson "1" *--> "jsonTodoReader 1" JsonTodoReader 
MigrateJsonToJson  ..>  JsonTodoReader : «create»
MigrateJsonToJson  ..>  JsonTodoWriter : «create»
MigrateJsonToJson "1" *--> "jsonTodoWriter 1" JsonTodoWriter 
MigrateJsonToJson  ..>  MigrationInterface 
TodoCheckFilename  ..>  CsvTodoStorage : «create»
TodoCheckFilename  ..>  JsonTodoStorage : «create»

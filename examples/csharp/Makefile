examples/csharp/create:

ifndef ExampleName
	$(error ExampleName is not set)
endif

ifndef ContextName
	$(error ContextName is not set)
endif

	mkdir $(ExampleName)
	dotnet new sln -n $(ExampleName) -o "./$(ExampleName)"
	dotnet new classlib -n $(ContextName) -o "./$(ExampleName)/src/$(ContextName)" --framework net5.0
	dotnet sln "./$(ExampleName)/$(ExampleName).sln" add "./$(ExampleName)/src/$(ContextName)/$(ContextName).csproj" -s "src"
	dotnet new xunit -n "$(ContextName).Tests" -o "./$(ExampleName)/test/$(ContextName).Tests" --framework net5.0
	dotnet sln "./$(ExampleName)/$(ExampleName).sln" add "./$(ExampleName)/test/$(ContextName).Tests/$(ContextName).Tests.csproj" -s "test"
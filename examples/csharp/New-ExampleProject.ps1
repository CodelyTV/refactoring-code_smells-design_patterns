param([Parameter(Mandatory=$true)][string]$ContextName, [Parameter(Mandatory=$true)][string]$ExampleName)

# Create folder and sln
New-Item -ItemType Directory -Path $ExampleName | Set-Location
dotnet new sln -n $ExampleName

# Create project
dotnet new classlib -n $ContextName -o "./src/$($ContextName)" --framework net5.0
dotnet sln "$($ExampleName).sln" add "./src/$($ContextName)/$($ContextName).csproj" -s "src"

# Create test project
dotnet new xunit -n "$($ContextName).Tests" -o "./test/$($ContextName).Tests" --framework net5.0
dotnet sln "$($ExampleName).sln" add "./test/$($ContextName).Tests/$($ContextName).Tests.csproj" -s "test"

# Return to original Path
Set-Location ..
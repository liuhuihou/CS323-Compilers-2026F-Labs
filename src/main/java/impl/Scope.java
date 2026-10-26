package impl;

import impl.symbol.FunctionSymbol;
import impl.symbol.VariableSymbol;
import impl.type.Type;

import java.util.LinkedHashMap;
import java.util.List;

public class Scope {
    protected Scope parent;
    protected final LinkedHashMap<String, VariableSymbol> variables = new LinkedHashMap<>();
    protected final LinkedHashMap<String, FunctionSymbol> functions = new LinkedHashMap<>();

    public Scope() {
        this(null);
    }

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public Scope getParent() {
        return parent;
    }

    public LinkedHashMap<String, VariableSymbol> getVariables() {
        return variables;
    }

    public LinkedHashMap<String, FunctionSymbol> getFunctions() {
        return functions;
    }

    // define variable
    public VariableSymbol defineVariable(String name, Type type) {
        //TODO:
        //If the current scope does not contain Variable, create one and add it to the current Scope;
        // otherwise, return null.
        VariableSymbol variableSymbol = new VariableSymbol(name, type);
        if (variables.get(name) == null) {
            variables.put(name, variableSymbol);
            return variableSymbol;
        }
        return null;
    }

    // define function
    public FunctionSymbol defineFunction(String name, Type returnType, List<VariableSymbol> params) {
        // TODO：
        // If the current scope does not contain a Function, create one and add it to the current Scope;
        // otherwise, return null
        FunctionSymbol newFunction = new FunctionSymbol(name,returnType,this);
        if (functions.get(name) == null) {
            functions.put(name, newFunction);
            for (VariableSymbol param : params) {
                newFunction.addParameter(param);
            }

            return newFunction;
        }
        return null;
    }

    public VariableSymbol lookupVariable(String name) {
        // TODO:
        //Find name in the current scope; if it exists, return the corresponding VariableSymbol.
        // If it does not exist, search in the parent scope
        // If it cannot be found, return null.

        return recursiveFindVariable(name,this);
    }

    private VariableSymbol recursiveFindVariable(String name, Scope scope) {
        if (scope == null) {
            return null;
        }
        if (scope.variables.containsKey(name)){
            return scope.variables.get(name);
        }else{
            return recursiveFindVariable(name, scope.parent);
        }
        
    }

    public VariableSymbol lookupCurrentVariable(String name) {
        return variables.getOrDefault(name, null);
    }

    public FunctionSymbol lookupFunction(String name) {
        //TODO:
        //Find name in the current scope; if it exists, return the corresponding FunctionSymbol.
        // If it does not exist, search in the parent scope
        // If it cannot be found, return null.
        return recursiveFindFunction(name, this);
    }

    private FunctionSymbol recursiveFindFunction(String name, Scope scope) {
        if (scope == null) {
            return null;
        }
        if (scope.functions.containsKey(name)){
            return scope.functions.get(name);
        }else{
            return recursiveFindFunction(name, scope.parent);
        }
        
    }
}

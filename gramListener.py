# Generated from gram.g4 by ANTLR 4.7.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .gramParser import gramParser
else:
    from gramParser import gramParser

# This class defines a complete listener for a parse tree produced by gramParser.
class gramListener(ParseTreeListener):

    # Enter a parse tree produced by gramParser#r.
    def enterR(self, ctx:gramParser.RContext):
        pass

    # Exit a parse tree produced by gramParser#r.
    def exitR(self, ctx:gramParser.RContext):
        pass


    # Enter a parse tree produced by gramParser#select_statement.
    def enterSelect_statement(self, ctx:gramParser.Select_statementContext):
        pass

    # Exit a parse tree produced by gramParser#select_statement.
    def exitSelect_statement(self, ctx:gramParser.Select_statementContext):
        pass


    # Enter a parse tree produced by gramParser#delete_statement.
    def enterDelete_statement(self, ctx:gramParser.Delete_statementContext):
        pass

    # Exit a parse tree produced by gramParser#delete_statement.
    def exitDelete_statement(self, ctx:gramParser.Delete_statementContext):
        pass


    # Enter a parse tree produced by gramParser#insert_statement.
    def enterInsert_statement(self, ctx:gramParser.Insert_statementContext):
        pass

    # Exit a parse tree produced by gramParser#insert_statement.
    def exitInsert_statement(self, ctx:gramParser.Insert_statementContext):
        pass


    # Enter a parse tree produced by gramParser#column.
    def enterColumn(self, ctx:gramParser.ColumnContext):
        pass

    # Exit a parse tree produced by gramParser#column.
    def exitColumn(self, ctx:gramParser.ColumnContext):
        pass


    # Enter a parse tree produced by gramParser#columnlist.
    def enterColumnlist(self, ctx:gramParser.ColumnlistContext):
        pass

    # Exit a parse tree produced by gramParser#columnlist.
    def exitColumnlist(self, ctx:gramParser.ColumnlistContext):
        pass


    # Enter a parse tree produced by gramParser#table.
    def enterTable(self, ctx:gramParser.TableContext):
        pass

    # Exit a parse tree produced by gramParser#table.
    def exitTable(self, ctx:gramParser.TableContext):
        pass


    # Enter a parse tree produced by gramParser#inputValue.
    def enterInputValue(self, ctx:gramParser.InputValueContext):
        pass

    # Exit a parse tree produced by gramParser#inputValue.
    def exitInputValue(self, ctx:gramParser.InputValueContext):
        pass


    # Enter a parse tree produced by gramParser#operators.
    def enterOperators(self, ctx:gramParser.OperatorsContext):
        pass

    # Exit a parse tree produced by gramParser#operators.
    def exitOperators(self, ctx:gramParser.OperatorsContext):
        pass


    # Enter a parse tree produced by gramParser#operands.
    def enterOperands(self, ctx:gramParser.OperandsContext):
        pass

    # Exit a parse tree produced by gramParser#operands.
    def exitOperands(self, ctx:gramParser.OperandsContext):
        pass


    # Enter a parse tree produced by gramParser#condition.
    def enterCondition(self, ctx:gramParser.ConditionContext):
        pass

    # Exit a parse tree produced by gramParser#condition.
    def exitCondition(self, ctx:gramParser.ConditionContext):
        pass



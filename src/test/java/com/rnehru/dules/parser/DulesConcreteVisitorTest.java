package com.rnehru.dules.parser;

import com.rnehru.dules.rule.Rule;
import com.rnehru.dules.rule.contextual.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.Test;

import java.time.format.DateTimeParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DulesConcreteVisitorTest {

    private DulesConcreteVisitor visitor = new DulesConcreteVisitor();

    @Test
    public void visitPageComplete_returnsPageCompleteRule_whenContextHasAString() {
        String page = "page";
        DulesParser.PageCompleteContext ctx = mock(DulesParser.PageCompleteContext.class);
        TerminalNode node = mock(TerminalNodeImpl.class);
        when(ctx.String()).thenReturn(node);
        when(node.getText()).thenReturn(page);

        Rule expected = new PageComplete(page);
        Rule actual = visitor.visitPageComplete(ctx);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void visitPageComplete_throwsException_whenContextIsNull() {
        visitor.visitPageComplete(null);
    }

    @Test(expected = NullPointerException.class)
    public void visitPageComplete_throwsException_whenContextHasNoString() {
        DulesParser.PageCompleteContext ctx = mock(DulesParser.PageCompleteContext.class);
        when(ctx.String()).thenReturn(null);

        visitor.visitPageComplete(ctx);
    }

    @Test
    public void visitAllPageComplete_returnsPageCompleteRule_whenContextHasAString() {
        DulesParser.AllPagesCompleteContext ctx = mock(DulesParser.AllPagesCompleteContext.class);

        Rule expected = new AllPagesComplete();
        Rule actual = visitor.visitAllPagesComplete(ctx);
        assertEquals(expected, actual);
    }

    @Test
    public void visitAnswerDateAfter_returnsAnswerDateAfter_whenContextHasRelevantFields() {
        DulesParser.AnswerDateAfterContext ctx = mock(DulesParser.AnswerDateAfterContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Date()).thenReturn(node2);
        when(node1.getText()).thenReturn("ident");
        when(node2.getText()).thenReturn("2010-01-01");

        Rule actual = visitor.visitAnswerDateAfter(ctx);
        Rule expected = new AnswerDateAfter("ident", "ident", "2010-01-01");

        assertEquals(expected, actual);
    }

    @Test(expected = DateTimeParseException.class)
    public void visitAnswerDateAfter_throwsException_whenContextHasUnparseableDate() {
        DulesParser.AnswerDateAfterContext ctx = mock(DulesParser.AnswerDateAfterContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Date()).thenReturn(node2);
        when(node1.getText()).thenReturn("ident");
        when(node2.getText()).thenReturn("bla");

        visitor.visitAnswerDateAfter(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerDateAfter_throwsException_whenContextIsMissingPageOrQuestion() {
        DulesParser.AnswerDateAfterContext ctx = mock(DulesParser.AnswerDateAfterContext.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(null);
        when(ctx.Date()).thenReturn(node2);
        when(node2.getText()).thenReturn("2010-01-01");

        visitor.visitAnswerDateAfter(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerDateAfter_throwsException_whenContextIsMissingDate() {
        DulesParser.AnswerDateAfterContext ctx = mock(DulesParser.AnswerDateAfterContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Date()).thenReturn(null);
        when(node1.getText()).thenReturn("ident");

        visitor.visitAnswerDateAfter(ctx);
    }

    @Test
    public void visitAnsweDateBefore_returnsAnswerDateAfter_whenContextHasRelevantFields() {
        DulesParser.AnswerDateBeforeContext ctx = mock(DulesParser.AnswerDateBeforeContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Date()).thenReturn(node2);
        when(node1.getText()).thenReturn("ident");
        when(node2.getText()).thenReturn("2010-01-01");

        Rule actual = visitor.visitAnswerDateBefore(ctx);
        Rule expected = new AnswerDateBefore("ident", "ident", "2010-01-01");

        assertEquals(expected, actual);
    }

    @Test(expected = DateTimeParseException.class)
    public void visitAnswerDateBefore_throwsException_whenContextHasUnparseableDate() {
        DulesParser.AnswerDateBeforeContext ctx = mock(DulesParser.AnswerDateBeforeContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Date()).thenReturn(node2);
        when(node1.getText()).thenReturn("ident");
        when(node2.getText()).thenReturn("bla");

        visitor.visitAnswerDateBefore(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerDateBefore_throwsException_whenContextIsMissingPageOrQuestion() {
        DulesParser.AnswerDateBeforeContext ctx = mock(DulesParser.AnswerDateBeforeContext.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(null);
        when(ctx.Date()).thenReturn(node2);
        when(node2.getText()).thenReturn("2010-01-01");

        visitor.visitAnswerDateBefore(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerDateBefore_throwsException_whenContextIsMissingDate() {
        DulesParser.AnswerDateBeforeContext ctx = mock(DulesParser.AnswerDateBeforeContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Date()).thenReturn(null);
        when(node1.getText()).thenReturn("ident");

        visitor.visitAnswerDateBefore(ctx);
    }

    @Test
    public void visitAnswerExists_returnsAnswerExists_whenContextHasPageAndQuestion() {
        DulesParser.AnswerExistsContext ctx = mock(DulesParser.AnswerExistsContext.class);
        TerminalNode node = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node);
        when(node.getText()).thenReturn("ident");

        Rule actual = visitor.visitAnswerExists(ctx);
        Rule expected = new AnswerExists("ident", "ident");

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerExists_throwsException_whenContextHasEmptyContext() {
        DulesParser.AnswerExistsContext ctx = mock(DulesParser.AnswerExistsContext.class);
        when(ctx.String(anyInt())).thenReturn(null);

        visitor.visitAnswerExists(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerExists_throwsException_whenContextIsNull() {
        visitor.visitAnswerExists(null);
    }

    @Test
    public void visitAnswerIn_returnsAnswerIn_whenContextHasRelevantData() {
        DulesParser.AnswerInContext ctx = mock(DulesParser.AnswerInContext.class);
        TerminalNode node = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node);
        when(ctx.Ref()).thenReturn(node);
        when(node.getText()).thenReturn("ident");

        Rule actual = visitor.visitAnswerIn(ctx);
        Rule expected = new AnswerIn("ident", "ident", "ident");

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerIn_throwsException_whenContextIsMissingStrings() {
        DulesParser.AnswerInContext ctx = mock(DulesParser.AnswerInContext.class);
        TerminalNode node = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(null);
        when(ctx.Ref()).thenReturn(node);
        when(node.getText()).thenReturn("ident");

        visitor.visitAnswerIn(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerIn_throwsException_whenContextIsMissingRef() {
        DulesParser.AnswerInContext ctx = mock(DulesParser.AnswerInContext.class);
        TerminalNode node = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node);
        when(ctx.Ref()).thenReturn(null);
        when(node.getText()).thenReturn("ident");

        visitor.visitAnswerIn(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerIn_throwsException_whenContextIsNull() {
        visitor.visitAnswerIn(null);
    }

    @Test
    public void visitAnswerLessThan_returnsAnswerLessThan_whenContextHasStringsAndNumber() {
        DulesParser.AnswerLessThanContext ctx = mock(DulesParser.AnswerLessThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Number()).thenReturn(node2);
        when(node1.getText()).thenReturn("ident");
        when(node2.getText()).thenReturn("4");

        Rule actual = visitor.visitAnswerLessThan(ctx);
        Rule expected = new AnswerLessThan("ident", "ident", 4);

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerLessThan_throwsException_whenContextHasStringsButNullNumber() {
        DulesParser.AnswerLessThanContext ctx = mock(DulesParser.AnswerLessThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Number()).thenReturn(null);
        when(node1.getText()).thenReturn("ident");

        visitor.visitAnswerLessThan(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerLessThan_throwsException_whenContextHasNumberButNulStrings() {
        DulesParser.AnswerLessThanContext ctx = mock(DulesParser.AnswerLessThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(null);
        when(ctx.Number()).thenReturn(node1);
        when(node1.getText()).thenReturn("4");

        visitor.visitAnswerLessThan(ctx);
    }

    @Test(expected = NumberFormatException.class)
    public void visitAnswerLessThan_throwsException_whenContextHasInvalidValueForNumber() {
        DulesParser.AnswerLessThanContext ctx = mock(DulesParser.AnswerLessThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Number()).thenReturn(node1);
        when(node1.getText()).thenReturn("ident");

        visitor.visitAnswerLessThan(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerLessThan_throwsException_whenContextIsNull() {
        visitor.visitAnswerLessThan(null);
    }

    @Test
    public void visitAnswerMoreThan_returnsAnswerLessThan_whenContextHasStringsAndNumber() {
        DulesParser.AnswerMoreThanContext ctx = mock(DulesParser.AnswerMoreThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        TerminalNode node2 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Number()).thenReturn(node2);
        when(node1.getText()).thenReturn("ident");
        when(node2.getText()).thenReturn("4");

        Rule actual = visitor.visitAnswerMoreThan(ctx);
        Rule expected = new AnswerMoreThan("ident", "ident", 4);

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerMoreThan_throwsException_whenContextHasStringsButNullNumber() {
        DulesParser.AnswerMoreThanContext ctx = mock(DulesParser.AnswerMoreThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Number()).thenReturn(null);
        when(node1.getText()).thenReturn("ident");

        visitor.visitAnswerMoreThan(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerMoreThan_throwsException_whenContextHasNumberButNulStrings() {
        DulesParser.AnswerMoreThanContext ctx = mock(DulesParser.AnswerMoreThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(null);
        when(ctx.Number()).thenReturn(node1);
        when(node1.getText()).thenReturn("4");

        visitor.visitAnswerMoreThan(ctx);
    }

    @Test(expected = NumberFormatException.class)
    public void visitAnswerMoreThan_throwsException_whenContextHasInvalidValueForNumber() {
        DulesParser.AnswerMoreThanContext ctx = mock(DulesParser.AnswerMoreThanContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(ctx.Number()).thenReturn(node1);
        when(node1.getText()).thenReturn("ident");

        visitor.visitAnswerMoreThan(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerMoreThan_throwsException_whenContextIsNull() {
        visitor.visitAnswerMoreThan(null);
    }

    @Test
    public void visitAnswerMatches_returnsAnswerMatches_whenContextHasStrings() {
        DulesParser.AnswerMatchesContext ctx = mock(DulesParser.AnswerMatchesContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String(anyInt())).thenReturn(node1);
        when(node1.getText()).thenReturn("ident");

        Rule expected = new AnswerMatches("ident", "ident", "ident");
        Rule actual = visitor.visitAnswerMatches(ctx);

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerMatches_throwsException_whenContextHasNullStrings() {
        DulesParser.AnswerMatchesContext ctx = mock(DulesParser.AnswerMatchesContext.class);
        when(ctx.String(anyInt())).thenReturn(null);

        visitor.visitAnswerMatches(ctx);
    }

    @Test(expected = NullPointerException.class)
    public void visitAnswerMatches_throwsException_whenContextIsNull() {
        visitor.visitAnswerMatches(null);
    }

    @Test
    public void visitPageExists_returnsPageExists_whenContextHasString() {
        DulesParser.PageExistsContext ctx = mock(DulesParser.PageExistsContext.class);
        TerminalNode node1 = mock(TerminalNodeImpl.class);
        when(ctx.String()).thenReturn(node1);
        when(node1.getText()).thenReturn("ident");

        Rule expected = new PageExists("ident");
        Rule actual = visitor.visitPageExists(ctx);

        assertEquals(expected, actual);
    }
}

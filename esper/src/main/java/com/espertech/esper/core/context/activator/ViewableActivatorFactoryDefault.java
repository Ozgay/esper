/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.core.context.activator;

import com.espertech.esper.client.EventType;
import com.espertech.esper.core.service.EPServicesContext;
import com.espertech.esper.core.service.ExprEvaluatorContextStatement;
import com.espertech.esper.core.service.StatementContext;
import com.espertech.esper.epl.expression.core.ExprEvaluator;
import com.espertech.esper.epl.named.NamedWindowProcessor;
import com.espertech.esper.epl.spec.FilterStreamSpecCompiled;
import com.espertech.esper.epl.spec.NamedWindowConsumerStreamSpec;
import com.espertech.esper.epl.spec.StatementSpecCompiled;
import com.espertech.esper.epl.table.mgmt.TableMetadata;
import com.espertech.esper.filter.FilterSpecCompiled;
import com.espertech.esper.metrics.instrumentation.InstrumentationAgent;
import com.espertech.esper.pattern.EvalRootFactoryNode;
import com.espertech.esper.pattern.PatternContext;
import com.espertech.esper.view.HistoricalEventViewable;

import java.lang.annotation.Annotation;

public class ViewableActivatorFactoryDefault implements ViewableActivatorFactory {

    public ViewableActivator createActivatorSimple(FilterStreamSpecCompiled filterStreamSpec) {
        throw new UnsupportedOperationException();
    }

    public ViewableActivator createFilterProxy(EPServicesContext services, FilterSpecCompiled filterSpec, Annotation[] annotations, boolean subselect, InstrumentationAgent instrumentationAgentSubquery, boolean isCanIterate, Integer streamNumFromClause) {
        return new ViewableActivatorFilterProxy(services, filterSpec, annotations, subselect, instrumentationAgentSubquery, isCanIterate);
    }

    public ViewableActivator createStreamReuseView(EPServicesContext services, StatementContext statementContext, StatementSpecCompiled statementSpec, FilterStreamSpecCompiled filterStreamSpec, boolean isJoin, ExprEvaluatorContextStatement evaluatorContextStmt, boolean filterSubselectSameStream, int streamNum, boolean isCanIterateUnbound) {
        return new ViewableActivatorStreamReuseView(services, statementContext, statementSpec, filterStreamSpec, isJoin, evaluatorContextStmt, filterSubselectSameStream, streamNum, isCanIterateUnbound);
    }

    public ViewableActivator createPattern(PatternContext patternContext, EvalRootFactoryNode rootFactoryNode, EventType eventType, boolean consumingFilters, boolean suppressSameEventMatches, boolean discardPartialsOnMatch, boolean isCanIterateUnbound) {
        return new ViewableActivatorPattern(patternContext, rootFactoryNode, eventType, consumingFilters, suppressSameEventMatches, discardPartialsOnMatch, isCanIterateUnbound);
    }

    public ViewableActivator createNamedWindow(NamedWindowProcessor processor, NamedWindowConsumerStreamSpec streamSpec, StatementContext statementContext) {
        return new ViewableActivatorNamedWindow(processor, streamSpec.getFilterExpressions(), streamSpec.getOptPropertyEvaluator(), statementContext.getEngineImportService(), statementContext.getStatementName());
    }

    public ViewableActivator createTable(TableMetadata metadata, ExprEvaluator[] optionalTableFilters) {
        return new ViewableActivatorTable(metadata, optionalTableFilters);
    }

    public ViewableActivator makeHistorical(HistoricalEventViewable historicalEventViewable) {
        return new ViewableActivatorHistorical(historicalEventViewable);
    }

    public ViewableActivator makeSubqueryNWIndexShare() {
        return new ViewableActivatorSubselectNone();
    }
}

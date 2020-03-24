import {Destructible, Dimensions, Resizable, Styleable} from './types/interfaces';
import FilterizrOptions from './FilterizrOptions';
import EventReceiver from './EventReceiver';
import StyledFilterizrElement from './StyledFilterizrElement';

export default abstract class FilterizrElement implements Destructible, Resizable, Styleable {
    node: Element;
    options: FilterizrOptions;
    readonly dimensions: Dimensions;
    abstract readonly styles: StyledFilterizrElement;
    protected eventReceiver: EventReceiver;

    constructor(node: Element, options: FilterizrOptions);

    destroy(): void | Promise<void>;

    trigger(eventType: string): void;

    protected abstract bindEvents(): void;

    protected abstract unbindEvents(): void;
}

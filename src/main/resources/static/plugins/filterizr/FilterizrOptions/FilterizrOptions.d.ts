import {BaseOptions, RawOptions} from './../types/interfaces';
import ActiveFilter from '../ActiveFilter';
import {Filter} from '../types';

export interface Options extends BaseOptions {
    filter: ActiveFilter;
}

export default class FilterizrOptions {
    readonly isSpinnerEnabled: boolean;
    readonly areControlsEnabled: boolean;
    readonly controlsSelector: string;
    filter: Filter;
    searchTerm: string;
    private options;
    private convertToFilterizrOptions;
    private convertToOptions;
    private validate;

    constructor(userOptions: RawOptions);

    toggleFilter(filter: string): void;

    get(): Options;

    getRaw(): RawOptions;

    set(newUserOptions: RawOptions): void;
}
